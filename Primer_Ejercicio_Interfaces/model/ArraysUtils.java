package enumerados.genero.model;

public class ArraysUtils {
	public static String arrayToString(Object[] objects) {
		StringBuilder sb = new StringBuilder();
		for(Object o : objects) {
			sb.append(o!=null?o: "").append(System.lineSeparator());
		}
		return sb.toString();
	}
}
