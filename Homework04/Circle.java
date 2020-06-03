public class Circle {

    public static final int ROWS = 13;
    public static final int COLUMNS = 25;
    static final String CANVAS = " ";
    static final String CIRCLE = "*";

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
    public void drawCircle() {
        int midpoint = COLUMNS / 2;
        int halfwaypoint = ROWS / 2;

        // canvas[0][midpoint] = CIRCLE;
        // canvas[0][midpoint+3] = CIRCLE;
        // canvas[0][midpoint-3] = CIRCLE;
        // canvas[1][midpoint+6] = CIRCLE;
        // canvas[1][midpoint-6] = CIRCLE;
        // canvas[2][midpoint+9] = CIRCLE;
        // canvas[2][midpoint-9] = CIRCLE;
        // canvas[3][midpoint+10] = CIRCLE;
        // canvas[3][midpoint-10] = CIRCLE;
        // canvas[4][midpoint+11] = CIRCLE;
        // canvas[4][midpoint-11] = CIRCLE;
        // canvas[5][midpoint+12] = CIRCLE;
        // canvas[5][midpoint-12] = CIRCLE;
        // canvas[6][midpoint+12] = CIRCLE;
        // canvas[6][midpoint-12] = CIRCLE;
        // canvas[7][midpoint+12] = CIRCLE;
        // canvas[7][midpoint-12] = CIRCLE;
        // canvas[8][midpoint+11] = CIRCLE;
        // canvas[8][midpoint-11] = CIRCLE;
        // canvas[9][midpoint+10] = CIRCLE;
        // canvas[9][midpoint-10] = CIRCLE;
        // canvas[10][midpoint+9] = CIRCLE;
        // canvas[10][midpoint-9] = CIRCLE;
        // canvas[11][midpoint+6] = CIRCLE;
        // canvas[11][midpoint-6] = CIRCLE;
        // canvas[12][midpoint+3] = CIRCLE;
        // canvas[12][midpoint-3] = CIRCLE;
        // canvas[12][midpoint] = CIRCLE;


        for (int x = 0; x < ROWS; x++) {
            switch (x) {
                case ROWS-ROWS:
                case ROWS-1:
                    for (int y=(midpoint-3);y<=(midpoint+3);y++)
                        canvas[x][y] = CIRCLE;
                    break;            
                case 1:
                case ROWS-2:
                    for (int y=(midpoint-6);y<=(midpoint+6);y++)
                        canvas[x][y] = CIRCLE;
                    break;            
                case 2:
                case ROWS-3:
                    for (int y=(midpoint-9);y<=(midpoint+9);y++)
                        canvas[x][y] = CIRCLE;
                    canvas[x][midpoint-9] = CANVAS;
                    canvas[x][midpoint+9] = CANVAS;
                    break;            
                case 3:
                case ROWS-4:
                    for (int y=(midpoint-10);y<=(midpoint+10);y++)
                        canvas[x][y] = CIRCLE;
                    canvas[x][midpoint-7] = CANVAS;
                    canvas[x][midpoint+7] = CANVAS;
                    break;            
                case 4:
                case ROWS-5:
                    for (int y=(midpoint-11);y<=(midpoint+11);y++)
                        canvas[x][y] = CIRCLE;
                    canvas[x][midpoint-6] = CANVAS;
                    canvas[x][midpoint+6] = CANVAS;
                    break;            
                    case (ROWS / 2)-1:
                case (ROWS / 2):
                case (ROWS / 2)+1:
                    for (int y=(midpoint-12);y<=(midpoint+12);y++)
                        canvas[x][y] = CIRCLE;
                    canvas[x][midpoint-5] = CANVAS;
                    canvas[x][midpoint+5] = CANVAS;
                    break;            
            }
            canvas[x][midpoint] = CANVAS;
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
        Circle circle = new Circle();
        circle.drawCanvas();
        circle.drawCircle();
        System.out.println(circle);
    }
}