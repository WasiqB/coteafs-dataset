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

import com.github.wasiqb.coteafs.dataset.IDataVariable;

/**
 * @author Wasiq Bhamla
 * @since Apr 22, 2018
 */
public class DataVariable implements IDataVariable {
	private final int		index;
	private final String	name;

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 22, 2018
	 * @param index
	 * @param name
	 */
	public DataVariable (final int index, final String name) {
		this.index = index;
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataVariable#index()
	 */
	@Override
	public int index () {
		return this.index;
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.dataset.IDataVariable#name()
	 */
	@Override
	public String name () {
		return this.name;
	}
}