/**
 * Copyright 2016, wizonsoft, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.wasiqb.coteafs.dataset.impl;

import com.github.wasiqb.coteafs.dataset.IDataColumn;
import com.github.wasiqb.coteafs.dataset.IDataVariable;

/**
 * @author Wasiq Bhamla
 * @since Apr 22, 2018
 */
public class DataColumn implements IDataColumn {
	private Object				value;
	private final IDataVariable	variable;

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 22, 2018
	 * @param index
	 * @param name
	 */
	public DataColumn (final int index, final String name) {
		this.variable = new DataVariable (index, name);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataColumn#value()
	 */
	@SuppressWarnings ("unchecked")
	@Override
	public <T> T value () {
		return (T) this.value;
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataColumn#value(java.lang.Object)
	 */
	@Override
	public <T> void value (final T newValue) {
		this.value = newValue;
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataColumn#variable()
	 */
	@Override
	public IDataVariable variable () {
		return this.variable;
	}
}