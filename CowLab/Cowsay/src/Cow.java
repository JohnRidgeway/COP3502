public class Cow {
    private String cowName;
    private String image;

    public Cow (String name) {
        cowName =  name;
    }
    public String getName () {
        return this.cowName;
    }
    public String getImage () {
        return this.image;
    }
    public void setImage (String _image) {
        this.image = _image;
    }
}
