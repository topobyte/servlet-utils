package de.topobyte.servlet.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class FileServing
{

	public static void serveUtf8(HttpServletResponse response, Path file)
			throws IOException
	{
		response.setCharacterEncoding("UTF-8");
		ServletOutputStream output = response.getOutputStream();
		Files.copy(file, output);
		output.close();
	}

	public static boolean serveUtf8IfExists(HttpServletResponse response,
			Path file) throws IOException
	{
		if (Files.exists(file) && Files.isRegularFile(file)) {
			serveUtf8(response, file);
			return true;
		}
		return false;
	}

	public static void serve(HttpServletResponse response, Path file)
			throws IOException
	{
		response.setCharacterEncoding("UTF-8");
		ServletOutputStream output = response.getOutputStream();
		Files.copy(file, output);
		output.close();
	}

	public static boolean serveIfExists(HttpServletResponse response, Path file)
			throws IOException
	{
		if (Files.exists(file) && Files.isRegularFile(file)) {
			serve(response, file);
			return true;
		}
		return false;
	}

}
