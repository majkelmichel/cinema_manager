package cinema.request.cinema;

public class RefundRequest {
    private String token;

    public RefundRequest() {
    }

    public RefundRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
