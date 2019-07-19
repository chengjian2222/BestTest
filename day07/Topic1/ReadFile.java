package day07.homework.Topic1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
	private String filePath;

	public static List<String> readFileBy(String filePath) throws FileNotFoundException {
		if (null == filePath) {
			return null;
		}
		List<String> result = new ArrayList<>();
		// 读取文件
		File file = new File(filePath);
		if (file.exists()) {
			// 文件存在
			// 3.
			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
				String value = null;
				while ((value = reader.readLine()) != null) {
					result.add(value);
				}
				return result;
			} catch (Exception ex) {
				System.out.println("Exception = " + ex);
				throw new IllegalStateException(ex);
			}
		} else {
			throw new FileNotFoundException("文件不存在");
		}
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
