public class Driver {
    public static void main(String[] args) {
        int[][][] data = Perceptron.treaingData;
        double[] weights = Perceptron.Initial_Weights;
        Perceptron perceptron = new Perceptron();
        boolean errorFlag = true;
        double error;
        while (errorFlag) {
            errorFlag = false;
            for (int i = 0; i < data.length; i++) {
                double[] adjustedWeights;
                double weightedSum = perceptron.calculateWeightedSum(data[i][0], weights);
                int result = perceptron.applyActivation(weightedSum);
                error = data[i][1][0] - result;
                System.out.println(weights[0] + "    " + weights[1]+"   error ="+error);
                if (error != 0) {
                    errorFlag = true;
                }
                adjustedWeights = perceptron.adjustWeights(data[i][0], weights, error);
                weights = adjustedWeights;
            }
        }
        int[] InPutData = {1, 0};
        double weightedSum = perceptron.calculateWeightedSum(InPutData, weights);
        System.out.println(perceptron.applyActivation(weightedSum));
    }
}
