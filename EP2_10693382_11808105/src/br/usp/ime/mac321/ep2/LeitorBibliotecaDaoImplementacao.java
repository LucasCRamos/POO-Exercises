package br.usp.ime.mac321.ep2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LeitorBibliotecaDaoImplementacao implements LeitorBibliotecaDAO {
	
	static List<Livro> livros;
	static List<Exemplar> exemplares;
	static List<Usuario>  usuarios;
	static List<Emprestimo> emprestimos;
	
	@Override
	public List<Livro> getAllLivros(String nomeArquivoLivros) {
		BufferedReader brLivro = null;
		livros = new ArrayList<Livro>();

			try {
	
				brLivro = new BufferedReader(new FileReader(nomeArquivoLivros));
				
				String linhaLivro = brLivro.readLine();
				
				do {
					
					 linhaLivro = brLivro.readLine();
					
					if(linhaLivro != null) {
					
						int tamanhoLinha = linhaLivro.length(); 
						
						int posicaoVirgula = linhaLivro.indexOf(','); 
						String idLivro = linhaLivro.substring(0, posicaoVirgula);
		
						int posicaoVirgulaAnterior = posicaoVirgula;
				        posicaoVirgula = linhaLivro.indexOf(",", posicaoVirgulaAnterior + 1);
				        String titulo = linhaLivro.substring(posicaoVirgulaAnterior + 1, posicaoVirgula); 
				        	        
				        posicaoVirgulaAnterior = posicaoVirgula;
				        posicaoVirgula = linhaLivro.indexOf(",", posicaoVirgulaAnterior + 1);
				        
				        String autores = linhaLivro.substring(posicaoVirgulaAnterior + 1, posicaoVirgula); 
				      
				        int numeroDeAutores=1;

			            for (int i=0;i<autores.length();i++){

			                if(autores.charAt(i)==';'){
			                    numeroDeAutores++;
			                }
			            }

			            String[] autor = new String[numeroDeAutores];
			            
			            if(numeroDeAutores > 1) {
			            	int posicaoPontoEVirgula = autores.indexOf(';'); 

				            autor[0] = autores.substring(0, posicaoPontoEVirgula);
	
				            for (int i = 1; i < numeroDeAutores; i++) {
	
				                if(i != numeroDeAutores-1){
	
				                    int posicaoPontoEVirgulaAnterior = posicaoPontoEVirgula;
				                    posicaoPontoEVirgula = autores.indexOf(';', posicaoPontoEVirgulaAnterior + 1); 
				                    autor[i] = autores.substring(posicaoPontoEVirgulaAnterior + 1, posicaoPontoEVirgula);
	
				                }
	
				                else{
	
				                    int ultimoPontoEVirgula = autores.lastIndexOf(';');
	
				                    autor[i] = autores.substring(ultimoPontoEVirgula+1,autores.length());
	
				                }
	
				            }
			            }
			            else
			            	autor[0] = autores;
			       
				        posicaoVirgulaAnterior = posicaoVirgula;
				        posicaoVirgula = linhaLivro.indexOf(",", posicaoVirgulaAnterior + 1);
				        String ano = linhaLivro.substring(posicaoVirgulaAnterior + 1, posicaoVirgula);
			        
				        posicaoVirgulaAnterior = posicaoVirgula;
				        posicaoVirgula = linhaLivro.indexOf(",", posicaoVirgulaAnterior + 1);
				        String editora = linhaLivro.substring(posicaoVirgulaAnterior + 1, posicaoVirgula);
						
				        posicaoVirgulaAnterior = posicaoVirgula;
				        posicaoVirgula = linhaLivro.indexOf(",", posicaoVirgulaAnterior + 1);
				        String edicao = linhaLivro.substring(posicaoVirgulaAnterior + 1, posicaoVirgula);
						
				        posicaoVirgulaAnterior = posicaoVirgula;
					     
			        	String idioma = linhaLivro.substring(posicaoVirgulaAnterior + 1, tamanhoLinha);
			        	
			        	if(verificaExistenciaLivro(idLivro)) 
			        		throw new MesmoIdentificador();
			        	else {
							Livro livro = new Livro(idLivro, titulo, autor, ano, editora, edicao, idioma);
							livros.add(livro);
			        	}
				     
					}
				     
				} while(linhaLivro != null);
			}
			
			catch (FileNotFoundException | UnsupportedEncodingException e) {
				
				System.err.println(e);
		        
			}
		        
		    catch (IOException e) {
		    	
		    	System.err.println(e);
				
			} catch (MesmoIdentificador e) {
				System.err.println(e);
			} 
			
			finally {
				
		        if (brLivro != null) {
		        	
		            try {
		            	
		            	brLivro.close();
		                
		            } catch (IOException e) {
		            	
		            	System.err.println(e);
		            }
		        }
		        
			}	
	
		return livros;
	}

	private boolean verificaExistenciaLivro(String idLivro){
		
		for (Livro l : livros) {
			
		      if (l.getIdLivro().equals(idLivro)) {
		    
		        return true;
		     }
		  }
		
		return false;
	}

	@Override
	public List<Exemplar> getAllExemplares(String nomeArquivoExemplares) {
		
		BufferedReader brExemplar = null;
		exemplares = new ArrayList<Exemplar>();

			try {
	
				brExemplar = new BufferedReader(new FileReader(nomeArquivoExemplares));
				
				String linhaExemplar = brExemplar.readLine();
				
				do {
					
					linhaExemplar = brExemplar.readLine();
					
					if(linhaExemplar != null) {
					
						int tamanhoLinha = linhaExemplar.length(); 
						
						int posicaoVirgula = linhaExemplar.indexOf(','); 
						String idExemplar = linhaExemplar.substring(0, posicaoVirgula);
					
				        String idLivro = linhaExemplar.substring(posicaoVirgula + 1, tamanhoLinha); 
				        
				        if(!verificaExistenciaLivro(idLivro)) 
				        	throw new ObjetoInexistente("Um exemplar de livro foi lido contendo uma referência a um livro que não existe.");
				        else {
							Exemplar exemplar = new Exemplar(idExemplar, idLivro);
							exemplares.add(exemplar);
				        }
				     
					}
				     
				} while(linhaExemplar != null);
			}
			
			catch (FileNotFoundException | UnsupportedEncodingException e) {
				
				System.err.println(e);
		        
			}
		        
		    catch (IOException e) {
		    	
		    	System.err.println(e);
				
			} catch (ObjetoInexistente e) {
				
				System.err.println(e);
			}
			
			finally {
				
		        if (brExemplar != null) {
		        	
		            try {
		            	
		            	brExemplar.close();
		                
		            } catch (IOException e) {
		            	
		            	System.err.println(e);
		            }
		        }
		        
			}	
	
		return exemplares;
	}


	@Override
	public List<Usuario> getAllUsuarios(String nomeArquivoUsuarios) {
	
		BufferedReader brUsuario = null;
		usuarios = new ArrayList<Usuario>();

			try {
	
				brUsuario = new BufferedReader(new FileReader(nomeArquivoUsuarios));
				
				String linhaUsuario = brUsuario.readLine();
				
				do {
					
					linhaUsuario = brUsuario.readLine();
					
					if(linhaUsuario != null) {
					
						int tamanhoLinha = linhaUsuario.length(); 
						
						int posicaoVirgula = linhaUsuario.indexOf(','); 
						String cpf = linhaUsuario.substring(0, posicaoVirgula);
						  
				        String nome = linhaUsuario.substring(posicaoVirgula + 1, tamanhoLinha); 
				       
						Usuario usuario = new Usuario(cpf, nome);
								
						usuarios.add(usuario);
					}
				     
				} while(linhaUsuario != null);
			}
			
			catch (FileNotFoundException | UnsupportedEncodingException e) {
				
				System.err.println(e);
		        
			}
		        
		    catch (IOException e) {
		    	
		    	System.err.println(e);
				
			}
			
			finally {
				
		        if (brUsuario != null) {
		        	
		            try {
		            	
		            	brUsuario.close();
		                
		            } catch (IOException e) {
		            	
		            	System.err.println(e);
		            }
		        }
		        
			}	
	
		return usuarios;
	}
	
	private boolean verificaExistenciaUsuario(String cpf){
		for (Usuario u : usuarios) {
		      if (u.getCpf().equals(cpf)) {	    	 
		        return true;
		     }
		  }
		
		return false;
	}
	
	private boolean verificaExistenciaExemplar(String idExemplar){

		for (Exemplar e : exemplares) {
		      if (e.getIdExemplar().equals(idExemplar)) {
		        return true;
		     }
		  }
		
		return false;
	}

	@Override
	public List<Emprestimo> getAllEmprestimos(String nomeArquivoEmprestimos) {
		
		BufferedReader brEmprestimo = null;
		emprestimos = new ArrayList<Emprestimo>();

			try {
	
				brEmprestimo = new BufferedReader(new FileReader(nomeArquivoEmprestimos));
				
				String linhaEmprestimo = brEmprestimo.readLine();
				
				do {
					
					linhaEmprestimo = brEmprestimo.readLine();
					
					if(linhaEmprestimo != null) {
					
						int tamanhoLinha = linhaEmprestimo.length(); 
						
						int posicaoVirgula = linhaEmprestimo.indexOf(','); 
						String cpf = linhaEmprestimo.substring(0, posicaoVirgula);
					  
						int posicaoVirgulaAnterior = posicaoVirgula;
				        posicaoVirgula = linhaEmprestimo.indexOf(",", posicaoVirgulaAnterior + 1);
				        String idExemplar = linhaEmprestimo.substring(posicaoVirgulaAnterior + 1, posicaoVirgula); 
				       
				        posicaoVirgulaAnterior = posicaoVirgula;
				        posicaoVirgula = linhaEmprestimo.indexOf(",", posicaoVirgulaAnterior + 1);
				        String dataEmprestimo = linhaEmprestimo.substring(posicaoVirgulaAnterior + 1, posicaoVirgula); 
					    
				        posicaoVirgulaAnterior = posicaoVirgula;
				        posicaoVirgula = linhaEmprestimo.indexOf(",", posicaoVirgulaAnterior + 1);
				        String dataRetorno = linhaEmprestimo.substring(posicaoVirgulaAnterior + 1, posicaoVirgula);
					
						Emprestimo emprestimo = new Emprestimo(cpf, idExemplar, dataEmprestimo);
						
						 posicaoVirgulaAnterior = posicaoVirgula;
					        if(posicaoVirgulaAnterior != tamanhoLinha-1) {
					        	 String dataRetornado = linhaEmprestimo.substring(posicaoVirgulaAnterior + 1, tamanhoLinha);
					        	emprestimo.setDataRetornoEfetivo(dataRetornado);
					        }
						
					    if (verificaExistenciaUsuario(cpf) && verificaExistenciaExemplar(idExemplar) )
					    	emprestimos.add(emprestimo);
	
			    		if(!verificaExistenciaUsuario(cpf) && verificaExistenciaExemplar(idExemplar))
		    				throw new ObjetoInexistente("Um empréstimo foi feito envolvendo um cliente que não existe.");
					    
			    		if(verificaExistenciaUsuario(cpf) && !verificaExistenciaExemplar(idExemplar))
					    	throw new ObjetoInexistente("Um empréstimo foi feito envolvendo um exemplar que não existe.");
					    	
			    		if (!verificaExistenciaUsuario(cpf) && !verificaExistenciaExemplar(idExemplar)) 
				    		throw new ObjetoInexistente("Um empréstimo foi feito envolvendo um cliente e um exemplar que não existem.");
					  
					}
				     
				} while(linhaEmprestimo != null);
			}
			
			catch (FileNotFoundException | UnsupportedEncodingException e) {
				
				System.err.println(e);
		        
			}
		        
		    catch (IOException e) {
		    	
		    	System.err.println(e);
				
			} catch (ObjetoInexistente e) {
				System.err.println(e);
			}
			
			finally {
				
		        if (brEmprestimo != null) {
		        	
		            try {
		            	
		                brEmprestimo.close();
		                
		            } catch (IOException e) {
		            	
		            	System.err.println(e);
		            }
		        }
		        
			}	
	
		return emprestimos;
	}

}