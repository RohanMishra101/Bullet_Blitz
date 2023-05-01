//package Entity;
//
//public class Bullet {
//    private int x;
//    private int y;
//    private int dx;
//    private int dy;
//    private int speed;
//    private int damage;
//    private boolean active;
//
//    public Bullet(int x, int y, int dx, int dy, int speed, int damage) {
//        this.x = x;
//        this.y = y;
//        this.dx = dx;
//        this.dy = dy;
//        this.speed = speed;
//        this.damage = damage;
//        this.active = true;
//    }
//
//    public void update() {
//        x += dx * speed;
//        y += dy * speed;
//    }
//
//    public void draw(Graphics2D g) {
//        g.setColor(Color.YELLOW);
//        g.fillOval(x, y, 10, 10);
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public int getDamage() {
//        return damage;
//    }
//
//    public boolean isActive() {
//        return active;
//    }
//
//    public void setActive(boolean active) {
//        this.active = active;
//    }
//}
