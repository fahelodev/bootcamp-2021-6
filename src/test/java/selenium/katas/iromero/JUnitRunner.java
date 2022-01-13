package katas.iromero;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
//se llaman .class ya que se la hace llamado al archivo en tiempo de ejecucion
@Suite.SuiteClasses({ReverseWordsTest.class, AlternatingCaseTest.class, BuyCarTest.class, DeclareWinnerTest.class})
public class JUnitRunner {

}