public class Heart {

    public static final int ROWS = 11;
    public static final int COLUMNS = 21;
    static final String CANVAS = " ";
    static final String HEART = "*";

    String[][] canvas = new String[ROWS][COLUMNS];

    public void drawCanvas() {
        for (int x = 0; x < canvas.length; x++) {
            for (int y = 0; y < canvas[x].length; y++) {
                canvas[x][y] = CANVAS;
            }
        }
    }

    /**
     * 
     */
    public void drawHeart() {
        int midpoint = COLUMNS / 2;
        int outerOffset = 0;
        int offset = 4;
        for (int x = 0; x < ROWS; x++) {
            if(x>5)
                outerOffset+=2;
            if(x<3)
                offset--;
            for (int y = 0; y < COLUMNS; y++) {                
                if (x<3) {
                    if ((y < offset) || (y > COLUMNS - (offset + 1))
                            || ((y < midpoint + offset) && (y > midpoint - offset)))
                        continue;                    
                } else {
                    if ((y < outerOffset) || (y > COLUMNS - (outerOffset + 1)))
                        continue;
                }
                canvas[x][y] = HEART;
            }
        }
    }

    public String toString() {
        StringBuffer sbuf = new StringBuffer();
        for (int x = 0; x < canvas.length; x++) {
            for (int y = 0; y < canvas[x].length; y++) {
                sbuf.append(canvas[x][y]);
            }
            sbuf.append("\n");
        }
        return sbuf.toString();
    }

    public static void main(String[] args) {
        Heart heart = new Heart();
        heart.drawCanvas();
        heart.drawHeart();
        System.out.println(heart);
    }
}