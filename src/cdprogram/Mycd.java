package cdprogram;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Mycd {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			StringTokenizer st = new StringTokenizer(scan.nextLine());		// split input by space
			processMycd(st);
		}
	}

	public static String processMycd(StringTokenizer st) {
		String out = "";
		if (st.nextToken().equals("mycd")) {
			ArrayDeque<String> path = new ArrayDeque<>();
			StringTokenizer pathString = new StringTokenizer(st.nextToken(), "/");		// split left path by / 
			while (pathString.hasMoreTokens()) {
				path.add(pathString.nextToken());		// construct original path
			}
			String newPath = st.nextToken();
			if (newPath.charAt(0) == '/') {
				path = new ArrayDeque<>();			// reset original path to root
			}
			pathString = new StringTokenizer(newPath, "/");		// split right path by /, multiple / will be consolidate to single /
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
					out += next + ": No such file or directory";
					break;
				} else {
					path.add(next);
				}
			}
			if (error == false) {
				if (path.isEmpty()) {
					System.out.println("/");
					out += "/";
				} else {
					for (String dir : path) {
						System.out.print("/" + dir);
						out += "/" + dir;
					}
					System.out.println();
				}
			}
		}
		return out;
	}
	
	static boolean isAlphanumeric(String s) {
		return Pattern.compile("[^a-zA-Z0-9]").matcher(s).find() ^ true;
	}
}
