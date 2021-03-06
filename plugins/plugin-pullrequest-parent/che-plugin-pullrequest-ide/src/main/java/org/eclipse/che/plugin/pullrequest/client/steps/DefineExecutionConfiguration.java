/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.plugin.pullrequest.client.steps;

import org.eclipse.che.plugin.pullrequest.client.workflow.Context;
import org.eclipse.che.plugin.pullrequest.client.workflow.Step;
import org.eclipse.che.plugin.pullrequest.client.workflow.WorkflowExecutor;

/**
 * This step defines ability to create forks.
 *
 * @author Mihail Kuznyetsov
 */
public class DefineExecutionConfiguration implements Step {

  @Override
  public void execute(WorkflowExecutor executor, Context context) {
    context.setForkAvailable(
        !context.getOriginRepositoryOwner().equals(context.getHostUserLogin()));
    executor.done(this, context);
  }
}
