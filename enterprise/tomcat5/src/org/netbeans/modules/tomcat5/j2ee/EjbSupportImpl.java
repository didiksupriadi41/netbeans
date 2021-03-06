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
package org.netbeans.modules.tomcat5.j2ee;

import java.io.File;
import org.netbeans.modules.j2ee.deployment.devmodules.api.J2eePlatform;
import org.netbeans.modules.javaee.specs.support.spi.EjbSupportImplementation;
import org.netbeans.modules.tomcat5.deploy.TomcatManager;

/**
 *
 * @author Martin Fousek <marfous@netbeans.org>
 */
public class EjbSupportImpl implements EjbSupportImplementation {

    private final TomcatManager manager;

    public EjbSupportImpl(TomcatManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean isEjb31LiteSupported(J2eePlatform j2eePlatform) {
        if (manager.isTomEE()) {
            return true;
        }

        for (File cpEntry : j2eePlatform.getClasspathEntries()) {
            if (cpEntry.getName().startsWith("openejb-tomcat")) { //NOI18N
                return true;
            }
        }
        return false;
    }

}
