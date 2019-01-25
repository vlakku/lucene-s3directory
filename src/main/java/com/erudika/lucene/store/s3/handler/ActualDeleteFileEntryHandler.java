/*
 * Copyright 2004-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.erudika.lucene.store.s3.handler;

import java.io.IOException;

/**
 * Removes file entries from the database by deleting the relevant rows from the database.
 *
 * @author kimchy
 */
public class ActualDeleteFileEntryHandler extends AbstractFileEntryHandler {

	@Override
	public void deleteFile(final String name) throws IOException {
		s3Directory.forceDeleteFile(name);
		s3Directory.getFileSizes().remove(name);
	}
}
