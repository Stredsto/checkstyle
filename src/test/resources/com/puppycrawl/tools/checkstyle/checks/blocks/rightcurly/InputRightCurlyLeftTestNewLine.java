/*
RightCurly
option = ALONE
tokens = CLASS_DEF, METHOD_DEF, CTOR_DEF, ANNOTATION_DEF, ENUM_DEF, INTERFACE_DEF


*/

package com.puppycrawl.tools.checkstyle.checks.blocks.rightcurly;

class InputRightCurlyLeftTestNewLine
{
    /** @see test method **/
    int foo() throws InterruptedException
    {
        int x = 1;
        int a = 2;
        while (true)
        {
            try
            {
                if (x > 0)
                {
                    break;
                }
                else if (x < 0) {
                    ;
                }
                else
                {
                    break;
                }
                switch (a)
                {
                case 0:
                    break;
                default:
                    break;
                }
            }
            catch (Exception e)
            {
                break;
            }
            finally
            {
                break;
            }
        }

        synchronized (this)
        {
            do
            {
                x = 2;
            } while (x == 2);
        }

        this.wait(666
                 ); // Bizarre, but legal

        for (int k = 0; k < 1; k++)
        {
            String innerBlockVariable = "";
        }

        // test input for bug reported by Joe Comuzzi
        if (System.currentTimeMillis() > 1000)
            return 1;
        else
            return 2;
    }

    // Test static initialiser
    static
    {
        int x = 1; // should not require any javadoc
    }



    public enum GreetingsEnum
    {
        HELLO,
        GOODBYE
    }; // violation ''}' at column 5 should be alone on a line'

    void method2()
    {
        boolean flag = true;
        if (flag) {
            System.identityHashCode("heh");
            flag = !flag; } String.CASE_INSENSITIVE_ORDER.
              equals("Xe-xe");
        // it is ok to have rcurly on the same line as previous
        // statement if lcurly on the same line.
        if (flag) { String.CASE_INSENSITIVE_ORDER.equals("it is ok."); }
    }
}

/**
 * Test input for closing brace if that brace terminates
 * a statement or the body of a constructor.
 */
class FooCtorTestNewLine
{
        int i;
        public void FooCtor()
    {
                i = 1;
    }} // 2 violations

/**
* Test input for closing brace if that brace terminates
* a statement or the body of a method.
*/
class FooMethodTestNewLine
{
        public void fooMethod()
    {
                int i = 1;
    }} // 2 violations

/**
* Test input for closing brace if that brace terminates
* a statement or the body of a named class.
*/
class FooInnerTestNewLine
{
        class InnerFoo
    {
                public void fooInnerMethod ()
        {

                }
    }} // 2 violations

/**
 * False positive
 *
 */
class Absent_CustomFieldSerializer3TestNewLine {

    public static void serialize() {} // violation ''}' at column 37 should be alone on a line'
}

class Absent_CustomFieldSerializer4TestNewLine
{
  void Absent_CustomFieldSerializer4() {} // violation ''}' at column 41 should be alone on a line'
}

class EmptyClass2TestNewLine {} // violation ''}' at column 31 should be alone on a line'

interface EmptyInterface3TestNewLine {} // violation ''}' at column 39 should be alone on a line'

class ClassWithStaticInitializersTestNewLine
{
    static {
    }
    static
    {}

    static class Inner
    {
        static {
            int i = 1;
        }
    }

    public void emptyBlocks() {
        try {
            // comment
        } catch (RuntimeException e) {
            new Object();
        } catch (Exception e) {
            // comment
        } catch (Throwable e) {
        } finally {
            // comment
        }

        do {
        } while (true);
    }

    public void codeAfterLastRightCurly() {
        while (new Object().equals(new Object())) {
        };
        for (int i = 0; i < 1; i++) { new Object(); };
    }

    static final java.util.concurrent.ThreadFactory threadFactory
            = new java.util.concurrent.ThreadFactory() {
        @Override
        public Thread newThread(final Runnable r) {
            return new Thread(r);
        }}; // violation ''}' at column 9 should be alone on a line'

    interface Interface1
    {
        int i = 1;
        public void meth1(); } // violation ''}' at column 30 should be alone on a line'

    interface Interface2
    { int i = 1; public void meth1(); } // violation ''}' at column 39 should be alone on a line'

    interface Interface3 {
        void display();
        interface Interface4 {
            void myMethod();
        }} // 2 violations
}
