package br.com.hitbra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class AvroLoader
{
	public static void loader( ) throws Exception
	{
		URL url = new URL(
				"https://svc_hitbra:12345@kafka-ddp-dev-saopaulo-adeo.aivencloud.com:16325/subjects/Shop/versions/4" );
		HttpURLConnection con = ( HttpURLConnection ) url.openConnection( );
		con.setRequestMethod( "GET" );

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader( url.openStream( ), "UTF-8" ) ))
		{
			for (String line ; ( line = reader.readLine( ) ) != null ; )
			{
				System.out.println( line );
			}
		}
	}
}
