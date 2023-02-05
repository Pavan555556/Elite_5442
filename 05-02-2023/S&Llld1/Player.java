public class Player {
    private String name;
    private int position;
    Player(String name, int position) {
        setName(name);
        setPosition(position);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }

}
