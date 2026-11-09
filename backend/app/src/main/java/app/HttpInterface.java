package app;

// this is required for the compiler to know T has the setId method in HttpHandler.java
public interface HttpInterface {
    public void setId(Long id);
}