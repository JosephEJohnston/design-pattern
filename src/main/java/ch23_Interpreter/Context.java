package ch23_Interpreter;

import java.util.StringTokenizer;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/12
 */
public class Context {
  private final StringTokenizer tokenizer;
  private String currentToken;

  public Context(String text) {
    tokenizer = new StringTokenizer(text);
    nextToken();
  }

  public String nextToken() {
    if (tokenizer.hasMoreTokens()) {
      currentToken = tokenizer.nextToken();
    } else {
      currentToken = null;
    }

    return currentToken;
  }

  public String currentToekn() {
    return currentToken;
  }

  public void skipToken(String token) throws ParseException {
    if (!token.equals(currentToken)) {
      throw new ParseException("Warning: " + token + " is expected, but "
          + currentToken + " is found.");
    }
    nextToken();
  }

  public int currentNumber() throws ParseException {
    int number = 0;
    try {
      number = Integer.parseInt(currentToken);
    } catch (NumberFormatException e) {
      throw new ParseException("Warning: " + e);
    }
    return number;
  }
}
