public class Dragon extends Cow {
    private String name;
    private String image;
    private boolean fireBreathing = true;

    public Dragon (String name, String image) {
        super(name);
        super.setImage(image);

    }

    public boolean canBreatheFire () {
        return fireBreathing;
    }
}

