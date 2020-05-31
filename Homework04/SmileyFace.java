public class SmileyFace {

    public static final int ROWS = 10;
    public static final int COLUMNS = 21;
    static final String CANVAS = " ";
    static final String NOSE = "👃";
    static final String EYES = "👁";
    static final String SMILE = "$";

    String[][] canvas = new String[ROWS][COLUMNS];

    public void drawCanvas() {
        for(int x=0; x<canvas.length; x++) {
            for(int y=0; y<canvas[x].length; y++) {
                canvas[x][y] = CANVAS;
            }
        }
    }

    /**
     * offset smile from nose (center point) by 1 row and span by 3 rows for big smile :D
     */
    public void drawSmile() {
        int centerX = ROWS / 2;
        int centerY = COLUMNS / 2;

        int smileRow = centerX + 1;

        // symmetrically to nose (8 column offset on both side from center)
        canvas[smileRow][centerY + 8] = "/";
        canvas[smileRow][centerY - 8] = "\\";

        // span smile to next row
        canvas[smileRow+1][centerY + 6] = "/";
        canvas[smileRow+1][centerY - 6] = "\\";

        // span smile to next row and fill the smile :D
        int end = centerY + 4;
        for (int y = centerY - 4; y <= end; y++) {
            canvas[smileRow + 2][y] = SMILE;
        }
    }

    /**
     * Offset eyes from nose (center point). Use the symmetrical principle your art teacher taught you ;-)
     */
    public void drawEyes() {
        int centerX = ROWS/2;
        int centerY = COLUMNS/2;

        // two rows above nose
        int eyeRow = centerX - 2;
        // symmetrically to nose (5 column offset on both side from center)
        canvas[eyeRow][centerY+5] = EYES;
        canvas[eyeRow][centerY-5] = EYES;

        // canvas[eyeRow][centerY + 4] = "(";
        // canvas[eyeRow][centerY + 6] = ")";
        // canvas[eyeRow][centerY - 6] = "(";
        // canvas[eyeRow][centerY - 4] = ")";

        // three rows above nose for brow
        eyeRow = centerX - 3;
        // symmetrically to nose (5 column offset on both side from center)
        canvas[eyeRow][centerY + 5] =" ͡";
        canvas[eyeRow][centerY - 5] = " ͡";

    }

    /**
     * use center point to place nose.
     */
    public void drawNose() {
        canvas[ROWS/2][COLUMNS/2] = NOSE;
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
        SmileyFace smileyFace = new SmileyFace();
        smileyFace.drawCanvas();
        smileyFace.drawNose();
        smileyFace.drawEyes();
        smileyFace.drawSmile();
        System.out.println(smileyFace);
    }
}