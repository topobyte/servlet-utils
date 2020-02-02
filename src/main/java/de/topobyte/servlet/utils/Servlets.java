// Copyright 2020 Sebastian Kuerten
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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlets
{

	public static void forwardToDefault(ServletRequest request,
			ServletResponse response) throws ServletException, IOException
	{
		ServletContext sc = request.getServletContext();
		RequestDispatcher rd = sc.getNamedDispatcher("default");
		rd.forward(request, response);
	}

}
