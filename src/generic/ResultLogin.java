package generic;

public class ResultLogin<T> {
    private boolean success;
    private T data;
    private String message;

    public ResultLogin(boolean success, T data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
