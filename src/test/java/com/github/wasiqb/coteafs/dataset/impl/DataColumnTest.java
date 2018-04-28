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

import static com.google.common.truth.Truth.assertThat;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.wasiqb.coteafs.dataset.IDataColumn;

/**
 * @author Wasiq Bhamla
 * @since Apr 28, 2018
 */
public class DataColumnTest {
	private IDataColumn col;

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@BeforeClass
	public void setup () {
		this.col = new DataColumn (1, "Name");
		this.col.value ("wizonsoft");
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testDataColumnValue () {
		assertThat (this.col.value ()
			.toString ()).isEqualTo ("wizonsoft");
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testDataColumnVariableIndex () {
		assertThat (this.col.variable ()
			.index ()).isEqualTo (1);
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testDataColumnVariableName () {
		assertThat (this.col.variable ()
			.name ()).isEqualTo ("Name");
	}
}