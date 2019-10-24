String aux[] = dataString.split("-");
String auxData = aux[2]+"/"+aux[1]+"/"+aux[0];

try {
			Date data = new Date(formato.parse(auxData).getTime());
			Contato contato = new Contato(nome, email, endereco, data, genero);
			ContatoDAO dao = new ContatoDAO();
			dao.cadastrar(contato);
		} catch (ParseException e) {		
			e.printStackTrace();
		}
