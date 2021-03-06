/**
 * Copyright (c) 2017-2020, Wasiq Bhamla.
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

package com.github.wasiqb.coteafs.dataset;

/**
 * @author Wasiq Bhamla
 * @param <T>
 *            Container
 * @since Apr 28, 2018
 */
public interface IDataIdentfiable <T> {
	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 * @return name
	 */
	String name ();

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 28, 2018
	 * @param name
	 * @return name
	 */
	T name (String name);
}