package shyam.ram.advance.model;
import com.google.gson.annotations.SerializedName;

public class ServerResponse {
    @SerializedName("ResponceCode")
    private String success;
    @SerializedName("ResponceMessage")
    private String message;
    public String getMessage() {
        return message;
    }
    public String getSuccess() {
        return success;
    }
}
