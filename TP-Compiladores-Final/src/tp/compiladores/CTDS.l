package tp.compiladores;

import java_cup.runtime.Symbol; 

%%
%class Yylex
%public
%unicode

%cup

%line
%column

%full
%char
%standalone
%{
  StringBuilder string = new StringBuilder();
  
  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }
   private void symbol(String s) {
    System.out.println(s);
  }
%}


/*literal*/
num = [0-9]
integer = {num}+
string = {letter}*
letter = [A-Za-z]
alphanumeric = {letter}|{num}
underscore = [_]
real = {integer}\.{integer}
ident = {letter}({alphanumeric}|{underscore})*

/*espacios*/
lineTerminator = \r|\n|\r\n
inputCharacter = [^\r\n]
whiteSpace =[ \t\f]

comment = {traditionalComment} | {endOfLineComment}
traditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
endOfLineComment = "//" {inputCharacter}* {lineTerminator}?


/* string and character literals */
StringCharacter = [^\r\n\"\\]
SingleCharacter = [^\r\n\'\\]

%state STRING, CHARLITERAL

%%

<YYINITIAL> {
/*operators*/
"-"     {return symbol(sym.MENOS); }
"-="     {return symbol(sym.MENOSIGUAL); }
"!"     {return symbol(sym.ADMIRACION); }
"!="     {return symbol(sym.ADMIRACIONIGUAL); }
"*"     {return symbol(sym.MULTIPLICACION); }
"/"     {return symbol(sym.DIVISION); }
"%"     {return symbol(sym.DIVENTERA); }
"+"     {return symbol(sym.SUMA); }
"+="     {return symbol(sym.SUMAIGUAL); }
"<"     {return symbol(sym.MENOR); }
"<="     {return symbol(sym.MENORIGUAL); }
">"     {return symbol(sym.MAYOR); }
">="     {return symbol(sym.MAYORIGUAL); }
"=" 	{return symbol(sym.IGUAL); }
"==" 	{return symbol(sym.IGUALIGUAL); }
"&&"    {return symbol(sym.CONJUNCION); }
"||"    {return symbol(sym.DISYUNCION); }

/*simbolos*/
";"		{return symbol(sym.PUNTOYCOMA); }
","		{return symbol(sym.COMA); }
"{"		{return symbol(sym.LLLAVE); }
"}"		{return symbol(sym.RLLAVE); }
"["		{return symbol(sym.LCORCHETE); }
"]"		{return symbol(sym.RCORCHETE); }
"("		{return symbol(sym.LPARENTESIS); }
")"		{return symbol(sym.RPARENTESIS); }

/*keywords*/
"if"         {return symbol(sym.IF); }
"for"        {return symbol(sym.FOR); }
"int"        {return symbol(sym.INT); }
"true"       {return symbol(sym.TRUE); }
"void"       {return symbol(sym.VOID); }
"else"       {return symbol(sym.ELSE); }
"false"      {return symbol(sym.FALSE); }
"while"      {return symbol(sym.WHILE); }
"break"      {return symbol(sym.BREAK); }
"class"      {return symbol(sym.CLASS); }
"float"      {return symbol(sym.FLT); }
"return"     {return symbol(sym.RETURN); }  
"boolean"    {return symbol(sym.BOOLEAN); }
"continue"   {return symbol(sym.CONTINUE); }
"externinvk" {return symbol(sym.EXTERNINVK); }

/*recog literal*/
{integer} {return symbol(sym.INTEGER, new Integer(yytext()));}
{real} {return symbol(sym.FLOAT, new Float(yytext()));}
{ident} {return symbol(sym.ID,new String(yytext()));}

/*espacios y comentarios*/
{whiteSpace} {/*Ignore*/}
{comment} {/*Ignore*/;}

/* string literal */
  \"                             { yybegin(STRING); string.setLength(0); }

  /* character literal */
  \'                             { yybegin(CHARLITERAL); }
  
}

<STRING> {
  \"                             { yybegin(YYINITIAL); return symbol(sym.STRING, new String(string.toString())); }
  
  {StringCharacter}+             { string.append( yytext() ); }
  
  /* escape sequences */
  "\\b"                          { string.append( '\b' ); }
  "\\t"                          { string.append( '\t' ); }
  "\\n"                          { string.append( '\n' ); }
  "\\f"                          { string.append( '\f' ); }
  "\\r"                          { string.append( '\r' ); }
  "\\\""                         { string.append( '\"' ); }
  "\\'"                          { string.append( '\'' ); }
  "\\\\"                         { string.append( '\\' ); }

  /* error cases */
  \\.                            { throw new RuntimeException("Illegal escape sequence \""+yytext()+"\""); }
}


. {throw new RuntimeException("Illegal character \""+yytext()+"\""); }
