// Copyright 2017 Sebastian Kuerten
//
// This file is part of servlet-utils.
//
// servlet-utils is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// servlet-utils is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with servlet-utils. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.servlet.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

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
