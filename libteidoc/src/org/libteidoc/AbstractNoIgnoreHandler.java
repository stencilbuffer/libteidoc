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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AbstractNoIgnoreHandler extends TEIElementHandler {
	
private static Logger logger = LogManager.getLogger(AbstractNoIgnoreHandler.class.getName());
	
	protected OutputDocument document;
	
	public AbstractNoIgnoreHandler(OutputDocument doc) {
		document = doc;
	}
	
	@Override
	public void characters(String s) {		
		//s = s.trim();
		if (!s.isEmpty()) {
			
			// Use addLine because of line length limit!
			document.write(s);
		}
	}

}
