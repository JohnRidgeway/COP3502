public class IceDragon extends Dragon {
    private String name;
    private String image;
    private boolean fireBreathing = false;

    public IceDragon (String name,String image) {
        super(name,image);
    }

    public boolean canBreatheFire () {
        return fireBreathing;
    }
}
