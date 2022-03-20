package it.polito.tdp.alien.model;

import java.util.*;
import java.util.regex.Pattern;

public class Dizionario {
	
	List<Parola> par;

	public Dizionario() {
		this.par = new LinkedList<Parola>();
	}
	
	public void add(String p, String t)
	{
		boolean  pp = Pattern.matches(("[a-zA-Z?]+"), p);
		boolean  pt = Pattern.matches(("[a-zA-Z?]+"), t);
		
		if(pp && pt)
		{
				for(Parola pa:par)
				{
					if(pa.nomeParola.compareTo(p)==0)
					{
						pa.getTraduzioni().add(t);
						return;
					}
				}
				
				Parola parr = new Parola(p);
				par.add(parr);
				parr.getTraduzioni().add(t);
		}
		
	}
	
	public List<String> translate(String p)
	{
		
		List<String> dt = new LinkedList<String>();
		
     	for(Parola pa:par)
		{
			if(pa.nomeParola.compareTo(p)==0)
			{
				return pa.getTraduzioni();
			}
			
			if(p.contains("?"))
			{
				int n = p.indexOf("?");
				n = n+1;
				
				if(pa.nomeParola.contains(p.substring(0,n-1)) && pa.nomeParola.contains(p.substring(n,p.length())))
				{
					dt.addAll(pa.getTraduzioni());
				}
			}
		}
		
		return dt;
	}
	
	

}
