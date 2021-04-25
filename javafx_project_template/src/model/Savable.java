package model;

public interface Savable {
    public String serialize();
    public void deserialize(String toDeserialize);
}
