/*******************************************************************************
 * Copyright 2013 Gabriel Siemoneit
 * 
 * This file is part of libteidoc.
 * 
 * libteidoc is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * 
 * libteidoc is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with libteidoc.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.libteidoc;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TEIContentHandler extends TEIElementHandler {
	
	private static Logger logger = LogManager.getLogger(TEIContentHandler.class.getName());
	protected final String lineSeparator = System.getProperty("line.separator");
	
	protected OutputDocument document;
	
	public TEIContentHandler(OutputDocument doc) {
		document = doc;
	}
	
	@Override
	public void characters(String s) {

		// Replace white spaces in between

		// Replace new line characters
		StringUtils.replace(s, lineSeparator, "");
		StringUtils.replace(s, "\n", "");

		// Replace any number of tab characters by one single white space
		s = StringUtils.replaceOnce(s, "\t", " ");
		s = StringUtils.replaceOnce(s, "	", " ");

		s = StringUtils.replace(s, "\t", "");
		s = StringUtils.replace(s, "	", "");

		// Workaround:
		// A simple 'trim' does not suffice as it would
		// also erase white spaces that were placed on purpose.
		boolean startsWith = s.startsWith(" ");
		boolean endsWith = s.endsWith(" ");

		s = s.trim();
		if (startsWith) {
			s = " " + s;
		}
		if (endsWith) {
			s += " ";
		}

		if (!s.isEmpty()) {
			document.write(s);
		}
	}
}
