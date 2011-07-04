/*
 * Copyright 2011 JBoss, a divison Red Hat, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.errai.ioc.rebind.ioc.codegen.builder.impl;

import org.jboss.errai.ioc.rebind.ioc.codegen.*;
import org.jboss.errai.ioc.rebind.ioc.codegen.builder.ClassStructureBuilderAbstractMethodOption;
import org.jboss.errai.ioc.rebind.ioc.codegen.builder.MethodBuildCallback;
import org.jboss.errai.ioc.rebind.ioc.codegen.meta.MetaClass;
import org.jboss.errai.ioc.rebind.ioc.codegen.meta.MetaClassFactory;
import org.jboss.errai.ioc.rebind.ioc.codegen.meta.impl.build.BuildMetaMethod;

/**
 * @author Christian Sadilek <csadilek@redhat.com>
 */
public class ClassBuilderAbstractMethodOption extends ClassBuilder<ClassStructureBuilderAbstractMethodOption> 
    implements ClassStructureBuilderAbstractMethodOption {

  ClassBuilderAbstractMethodOption(ClassBuilder that, Context context) {
    super(that, context);
  }

  @Override
  public MethodBlockBuilderAbstractOption<ClassStructureBuilderAbstractMethodOption> publicAbstractMethod(
      MetaClass returnType, String name) {
    return genMethod(Scope.Public, returnType, name, DefParameters.none());
  }

  @Override
  public MethodBlockBuilderAbstractOption<ClassStructureBuilderAbstractMethodOption> publicAbstractMethod(
      Class<?> returnType, String name) {
    return publicAbstractMethod(MetaClassFactory.get(returnType), name);
  }

  @Override
  public MethodBlockBuilderAbstractOption<ClassStructureBuilderAbstractMethodOption> publicAbstractMethod(
      MetaClass returnType, String name, MetaClass... parms) {
    return genMethod(Scope.Public, returnType, name, DefParameters.fromTypeArray(parms));
  }

  @Override
  public MethodBlockBuilderAbstractOption<ClassStructureBuilderAbstractMethodOption> publicAbstractMethod(
      Class<?> returnType, String name, Class<?>... parms) {
    return publicAbstractMethod(MetaClassFactory.get(returnType), name, MetaClassFactory.fromClassArray(parms));
  }

  @Override
  public MethodBlockBuilderAbstractOption<ClassStructureBuilderAbstractMethodOption> publicAbstractMethod(
      MetaClass returnType, String name, Parameter... parms) {
    return genMethod(Scope.Public, returnType, name, DefParameters.fromParameters(parms));
  }

  @Override
  public MethodBlockBuilderAbstractOption<ClassStructureBuilderAbstractMethodOption> publicAbstractMethod(
      Class<?> returnType, String name, Parameter... parms) {
    return publicAbstractMethod(MetaClassFactory.get(returnType), name, parms);
  }

  @Override
  public MethodBlockBuilderAbstractOption<ClassStructureBuilderAbstractMethodOption> protectedAbstractMethod(
      MetaClass returnType, String name) {
    return genMethod(Scope.Protected, returnType, name, DefParameters.none());
  }

  @Override
  public MethodBlockBuilderAbstractOption<ClassStructureBuilderAbstractMethodOption> protectedAbstractMethod(
      Class<?> returnType, String name) {
    return protectedAbstractMethod(MetaClassFactory.get(returnType), name);
  }

  @Override
  public MethodBlockBuilderAbstractOption<ClassStructureBuilderAbstractMethodOption> protectedAbstractMethod(
      MetaClass returnType, String name, MetaClass... parms) {
    return genMethod(Scope.Protected, returnType, name, DefParameters.fromTypeArray(parms));
  }

  @Override
  public MethodBlockBuilderAbstractOption<ClassStructureBuilderAbstractMethodOption> protectedAbstractMethod(
      Class<?> returnType, String name, Class<?>... parms) {
    return protectedAbstractMethod(MetaClassFactory.get(returnType), name, MetaClassFactory.fromClassArray(parms));
  }

  @Override
  public MethodBlockBuilderAbstractOption<ClassStructureBuilderAbstractMethodOption> protectedAbstractMethod(
      MetaClass returnType, String name, Parameter... parms) {
    return genMethod(Scope.Protected, returnType, name, DefParameters.fromParameters(parms));
  }

  @Override
  public MethodBlockBuilderAbstractOption<ClassStructureBuilderAbstractMethodOption> protectedAbstractMethod(
      Class<?> returnType, String name, Parameter... parms) {
    return protectedAbstractMethod(MetaClassFactory.get(returnType), name, parms);
  }

  @Override
  public MethodBlockBuilderAbstractOption<ClassStructureBuilderAbstractMethodOption> packageAbstractMethod(
      MetaClass returnType, String name) {
    return genMethod(Scope.Package, returnType, name, DefParameters.none());
  }

  @Override
  public MethodBlockBuilderAbstractOption<ClassStructureBuilderAbstractMethodOption> packageAbstractMethod(
      Class<?> returnType, String name) {
    return packageAbstractMethod(MetaClassFactory.get(returnType), name);
  }

  @Override
  public MethodBlockBuilderAbstractOption<ClassStructureBuilderAbstractMethodOption> packageAbstractMethod(
      MetaClass returnType, String name, MetaClass... parms) {
    return genMethod(Scope.Package, returnType, name, DefParameters.fromTypeArray(parms));
  }

  @Override
  public MethodBlockBuilderAbstractOption<ClassStructureBuilderAbstractMethodOption> packageAbstractMethod(
      Class<?> returnType, String name, Class<?>... parms) {
    return packageAbstractMethod(MetaClassFactory.get(returnType), name, MetaClassFactory.fromClassArray(parms));
  }

  @Override
  public MethodBlockBuilderAbstractOption<ClassStructureBuilderAbstractMethodOption> packageAbstractMethod(
      MetaClass returnType, String name, Parameter... parms) {
    return genMethod(Scope.Package, returnType, name, DefParameters.fromParameters(parms));
  }

  @Override
  public MethodBlockBuilderAbstractOption<ClassStructureBuilderAbstractMethodOption> packageAbstractMethod(
      Class<?> returnType, String name, Parameter... parms) {
    return packageAbstractMethod(MetaClassFactory.get(returnType), name, parms);
  }

  private MethodBlockBuilderAbstractOption<ClassStructureBuilderAbstractMethodOption> genMethod(final Scope scope,
      final MetaClass returnType,
      final String name,
      final DefParameters defParameters) {

    return new MethodBlockBuilderAbstractOption<ClassStructureBuilderAbstractMethodOption>(
            new MethodBuildCallback<ClassStructureBuilderAbstractMethodOption>() {
      @Override
      public ClassStructureBuilderAbstractMethodOption callback(final Statement statement,
                                                                final DefModifiers modifiers,
                                                                final ThrowsDeclaration throwsDeclaration) {
        BuildMetaMethod buildMetaMethod = new BuildMetaMethod(classDefinition, statement, scope, name,
            returnType, defParameters, throwsDeclaration, true);

        classDefinition.addMethod(buildMetaMethod);
        return ClassBuilderAbstractMethodOption.this;
      }
    });
  }
}