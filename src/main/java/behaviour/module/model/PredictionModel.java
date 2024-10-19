package behaviour.module.model;

public class PredictionModel {
private int Arr[];
private int Cluster;
private String DocName[];
public String[] getDocName() {
	return DocName;
}

public void setDocName(String[] docName) {
	DocName = docName;
}

public int getCluster() {
	return Cluster;
}

public void setCluster(int cluster) {
	Cluster = cluster;
}

private double ArrayVectors[]; 
public int[] getArr() {
	return Arr;
}

public void setArr(int[] arr) {
	Arr = arr;
}

public double[] getArrayVectors() {
	return ArrayVectors;
}

public void setArrayVectors(double[] arrayVectors) {
	ArrayVectors = arrayVectors;
}
}
