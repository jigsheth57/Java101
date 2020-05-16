public class SimpleCalculator {

    private double running_total = 0.0;

    public double getRunningTotal() {
        return running_total;
    }

    public void setRunningTotal(double x) {
        running_total = x;
    }

    public double add(double x) {
        running_total = running_total + x;
        return running_total;
    }

    public double subtract(double x) {
        running_total = running_total - x;
        return running_total;
    }

    public double multiply(double x) {
        running_total = running_total * x;
        return running_total;
    }

    public double divid(double x) {
        running_total = running_total / x;
        return running_total;
    }

    public double performOperation(char operation, double x) {
        switch (operation) {
            case '+': return add(x);
            case '-': return subtract(x);
            case '*': return multiply(x);
            case '/': return divid(x);
        } 
        
        return running_total;
    }
}