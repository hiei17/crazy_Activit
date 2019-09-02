package org.crazyit.drools;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class TestAsm {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		// 访问类的头部分
		cw.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC, "org/crazyit/test/MyObject",
				null, "java/lang/Object", null);
		// 访问方法，创建构造器
		MethodVisitor construct = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>",
				"()V", null, null);
		construct.visitCode();
		construct.visitVarInsn(Opcodes.ALOAD, 0);
		construct.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object",
				"<init>", "()V");
		construct.visitInsn(Opcodes.RETURN);
		construct.visitMaxs(0, 0);
		construct.visitEnd(); // 结束方法访问
		// 访问属性，创建userName属性
		FieldVisitor fv = cw.visitField(Opcodes.ACC_PRIVATE, "userName",
				"LString;", null, null);
		fv.visitEnd(); // 结束属性访问
		cw.visitEnd(); // 结束类访问
		final byte[] code = cw.toByteArray();
		// 根据字节数组创建Class
		Class clazz = new ClassLoader() {
			protected Class findClass(String name)
					throws ClassNotFoundException {
				return defineClass(name, code, 0, code.length);
			}
		}.loadClass("org.crazyit.test.MyObject");
		// 实例化对象
		Object obj = clazz.newInstance();
		System.out.println(obj);

	}

}
