package task;

public enum Direction {
    North() {
        public Vector2 move(Vector2 start, double distance)
        {
            Vector2 res = new Vector2(start.getX(), start.getY() - distance);
            return res;
        }
    },
    South(){
        public Vector2 move(Vector2 start, double distance)
        {
            Vector2 res = new Vector2(start.getX(), start.getY() + distance);
            return res;
        }
    },
    West(){
        public Vector2 move(Vector2 start, double distance)
        {
            Vector2 res = new Vector2(start.getX() - distance, start.getY());
            return res;
        }
    },
    East() {
        public Vector2 move(Vector2 start, double distance)
        {
            Vector2 res = new Vector2(start.getX() + distance, start.getY());
            return res;
        }
    };

    public abstract Vector2 move(Vector2 start, double distance);
}
