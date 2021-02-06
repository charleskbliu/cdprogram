package cdprogram;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Mycd {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			StringTokenizer st = new StringTokenizer(scan.nextLine());
			if (st.nextToken().equals("mycd")) {
				ArrayDeque<String> path = new ArrayDeque<>();
				StringTokenizer pathString = new StringTokenizer(st.nextToken(), "/");
				while (pathString.hasMoreTokens()) {
					path.add(pathString.nextToken());
				}
				String newPath = st.nextToken();
				if (newPath.charAt(0) == '/') {
					path = new ArrayDeque<>();
				}
				pathString = new StringTokenizer(newPath, "/");
				boolean error = false;
				while (pathString.hasMoreTokens()) {
					String next = pathString.nextToken();
					if (next.equals(".")) {
						continue;
					} else if (next.equals("..")) {
						if (path.isEmpty() == false) {
							path.removeLast();
						}
					} else if (isAlphanumeric(next) == false) {
						error = true;
						System.out.println(next + ": No such file or directory");
						break;
					} else {
						path.add(next);
					}
				}
				if (error == false) {
					if (path.isEmpty()) {
						System.out.println("/");
					} else {
						for (String dir : path) {
							System.out.print("/" + dir);
						}
						System.out.println();
					}
				}
			}
		}
	}

	static boolean isAlphanumeric(String s) {
		return Pattern.compile("[^a-zA-Z0-9]").matcher(s).find() ^ true;
	}
}
