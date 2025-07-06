package generic;

import com.mongodb.client.*;
import org.bson.Document;
import java.util.*;
import java.util.function.Function;
import static com.mongodb.client.model.Filters.eq;
import ConnectorDb.mongoDb;

public class AktivitasHalper<T> {

    private final MongoCollection<Document> collection;
    private final Function<Document, T> fromDoc;
    private final Function<T, Document> toDoc;

    public AktivitasHalper(String collectionName, Function<Document, T> fromDoc, Function<T, Document> toDoc) {
        this.collection = mongoDb.getDatabase().getCollection(collectionName);
        this.fromDoc = fromDoc;
        this.toDoc = toDoc;
    }

    public void insert(T data) {
        Document doc = toDoc.apply(data);
        collection.insertOne(doc);
    }

    public List<T> getByUser(String userId) {
        List<T> list = new ArrayList<>();
        for (Document d : collection.find(eq("userId", userId))) {
            list.add(fromDoc.apply(d));
        }
        return list;
    }

    // Tambahkan method untuk update dan delete jika diperlukan
    public boolean update(String id, T data) {
        try {
            collection.replaceOne(eq("_id", new org.bson.types.ObjectId(id)), toDoc.apply(data));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void delete(String id) {
        collection.deleteOne(eq("_id", new org.bson.types.ObjectId(id)));
    }
}
