public class SmileyFace {

    public static final int ROWS = 10;
    public static final int COLUMNS = 21;

    String[][] canvas = new String[ROWS][COLUMNS];

    public void drawCanvas() {
        for(int x=0; x<canvas.length; x++) {
            for(int y=0; y<canvas[x].length; y++) {
                canvas[x][y] = "-";
            }
        }
    }

    public void drawSmile() {
        int center = ROWS/2;
        int row = center + 1;
        canvas[row][2] = "$";
        canvas[row][COLUMNS-3] = "$";
        canvas[row+1][4] = "$";
        canvas[row+1][COLUMNS-5] = "$";
        int end = COLUMNS-7;
        for(int y=6;y<=end;y++) {
            canvas[row+2][y] = "$";
        }
    }

    public void drawEyes() {
        int row = canvas.length / 2 - 2;
        int center = COLUMNS/2;
        canvas[row][center+5] = "0";
        canvas[row][center-5] = "0";
    }

    public void drawNose() {
        int row = canvas.length/2;
        canvas[row][COLUMNS/2] = "?";
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
        smileyFace.drawSmile();
        smileyFace.drawEyes();
        smileyFace.drawNose();
        System.out.println(smileyFace);
    }
}