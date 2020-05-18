import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class GraphGenerator {
	public WeightedGraph graph;
	public double[] x = new double[23];
	public double[] y = new double[23];
	
	public GraphGenerator(int vertexNumber) {
		graph = new WeightedGraph(vertexNumber);
	}
	
	public WeightedGraph generateGraph() {
		double[][] matrix = new double[23][23];
		BufferedReader br = null;
		int index = 0;
		try {
			br = new BufferedReader(new FileReader(new File("Matrix.txt")));
			String buffer = "";
			while((buffer = br.readLine()) != null) {
				String[] arr = buffer.split(" ");
				for(int i = 0; i < arr.length; i++) {
					if(!arr[i].equals("﻿0")) {
						matrix[index][i] = Double.parseDouble(arr[i]);
					}
				}
				index++;
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			br = new BufferedReader(new FileReader(new File("coordinates.txt")));
		
			String buffer = "";
			buffer = br.readLine();
			String[] arr = buffer.split(" ");
			for(int i = 0; i < arr.length; i++) {
				x[i] = Double.parseDouble(arr[i]);
//				System.out.print(x[i] + " ");
			}
			buffer = br.readLine();
			arr = buffer.split(" ");
			for(int i = 0; i < arr.length; i++) {
				y[i] = Double.parseDouble(arr[i]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < x.length; i++) {
			graph.addVertex(i, x[i], y[i]);
		}
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] != 0.0) {
					graph.addEdge(i, j, matrix[i][j]);
				}
			}
		}
		return graph;
	}
	
}
