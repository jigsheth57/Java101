public class Circle {

    public static final int ROWS = 13;
    public static final int COLUMNS = 31;
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
                case 0:
                case ROWS-1:
                    for (int y=(midpoint-3);y<=(midpoint+3);y++)
                        canvas[x][y] = CIRCLE;
                    // canvas[x][midpoint] = CIRCLE;                                                
                    // canvas[x][midpoint+3] = CIRCLE;
                    // canvas[x][midpoint-3] = CIRCLE;
                    break;            
                case 1:
                case ROWS-2:
                    for (int y=(midpoint-6);y<=(midpoint+6);y++)
                        canvas[x][y] = CIRCLE;
                    // canvas[x][midpoint+6] = CIRCLE;
                    // canvas[x][midpoint-6] = CIRCLE;
                    break;            
                case 2:
                case ROWS-3:
                for (int y=(midpoint-9);y<=(midpoint+9);y++)
                    canvas[x][y] = CIRCLE;
            // canvas[x][midpoint+9] = CIRCLE;
            //         canvas[x][midpoint-9] = CIRCLE;
                    break;            
                case 3:
                case ROWS-4:
                    canvas[x][midpoint+10] = CIRCLE;
                    canvas[x][midpoint-10] = CIRCLE;
                    break;            
                case 4:
                case ROWS-5:
                    canvas[x][midpoint+11] = CIRCLE;
                    canvas[x][midpoint-11] = CIRCLE;
                    break;            
                case (ROWS / 2)-1:
                case (ROWS / 2):
                case (ROWS / 2)+1:
                    canvas[x][midpoint+12] = CIRCLE;
                    canvas[x][midpoint-12] = CIRCLE;
                    break;                            
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
        Circle circle = new Circle();
        circle.drawCanvas();
        circle.drawCircle();
        System.out.println(circle);
    }
}