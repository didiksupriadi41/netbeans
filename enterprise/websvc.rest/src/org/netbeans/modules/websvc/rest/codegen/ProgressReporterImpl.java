/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.websvc.rest.codegen;

import org.netbeans.modules.j2ee.persistence.wizard.jpacontroller.ProgressReporter;


/**
 * @author ads
 *
 */
class ProgressReporterImpl implements ProgressReporter {

    ProgressReporterImpl( AbstractGenerator generator ) {
        this.generator = generator;
    }

    /* (non-Javadoc)
     * @see org.netbeans.modules.j2ee.persistence.wizard.jpacontroller.ProgressReporter#progress(java.lang.String, int)
     */
    @Override
    public void progress( String message, int unit ) {
        if ( message != null ){
            generator.reportProgress(message);
        }
    }

    private AbstractGenerator generator; 
}
