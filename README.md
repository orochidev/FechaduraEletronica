# Fechadura

Foi feita a parte de verificar a conexão, recuperar um JSON de um link e também trasnformar este JSON em objetos SALA.
O timestamp recuperado do JSON tem que ser usado sem o "T" no meio da string: "2017-11-05 04:12:12.213". Este procedimento está sendo feito para que possa ser usado o SimpleDateFormat.