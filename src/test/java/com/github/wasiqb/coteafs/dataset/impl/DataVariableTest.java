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

import com.github.wasiqb.coteafs.dataset.IDataVariable;

/**
 * @author Wasiq Bhamla
 * @since Apr 28, 2018
 */
public class DataVariableTest {
	private IDataVariable var;

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@BeforeClass
	public void setup () {
		this.var = new DataVariable (1, "Name");
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testDataVariableIndex () {
		assertThat (this.var.index ()).isEqualTo (1);
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 */
	@Test
	public void testDataVariableName () {
		assertThat (this.var.name ()).isEqualTo ("Name");
	}
}