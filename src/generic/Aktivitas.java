/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generic;

import java.io.Serializable;
import java.util.Date;
import org.bson.Document;

public class Aktivitas implements Serializable {

    private String nama;
    private String deskripsi;
    private Date tanggal;
    private String waktu;
    private String status;
    private String id;

    public Aktivitas(String nama, String deskripsi, Date tanggal, String waktu, String status) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.status = status;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    public String getStatus() {
        return status;
    }

    public String getId() {
        return id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object[] toRow(int no) {
        return new Object[]{no, nama, deskripsi, tanggal, waktu, status};
    }

    public Document toDocument() {
        Document doc = new Document("nama", nama)
                .append("deskripsi", deskripsi)
                .append("tanggal", tanggal)
                .append("waktu", waktu)
                .append("status", status)
                .append("userId", loginSession.getUserId());

        if (id != null) {
            doc.append("_id", new org.bson.types.ObjectId(id));
        }
        return doc;
    }

    public static Aktivitas fromDocument(Document doc) {
        Aktivitas aktivitas = new Aktivitas(
                doc.getString("nama"),
                doc.getString("deskripsi"),
                doc.getDate("tanggal"),
                doc.getString("waktu"),
                doc.getString("status"));

        // Tambahkan ini untuk mengisi ID dari dokumen
        if (doc.getObjectId("_id") != null) {
            aktivitas.setId(doc.getObjectId("_id").toString());
        }
        return aktivitas;
    }
}
