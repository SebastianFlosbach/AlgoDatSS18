package data;

import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import entities.graph.Graph;

/**
 * This class implements the functionality to read a Graph from an Xml-File
 * @author Sebastian
 *
 */
public class XmlGraphReader {
	
	private String m_Path;
	
	private DocumentBuilderFactory m_DocumentBuilderFactory;
	private DocumentBuilder m_DocumentBuilder = null;
	
	/**
	 * Create a new instance of this class
	 * @param _path Path to the xml file
	 */
	public XmlGraphReader(String _path) {
		m_Path = _path;
		m_DocumentBuilderFactory = DocumentBuilderFactory.newInstance();
		
		try {
			m_DocumentBuilder = m_DocumentBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads the Xml-File and creates a Graph object from it
	 * @return A new Graph from Xml
	 */
	public Graph ReadGraph() {
		
		Document document = null;
		
		try {
			document = m_DocumentBuilder.parse(new FileInputStream(m_Path));
		} catch (Exception e) {
			System.out.println("Error: Could not find specified path!");
			return null;
		}
		
		Graph graph = null;
		
		document.getDocumentElement().normalize();
		
		Node rootElement = document.getFirstChild();
		
		for(int i = 0; i < rootElement.getChildNodes().getLength(); i++) {
			Node currentNode = rootElement.getChildNodes().item(i);
			
			if(currentNode.getNodeType() == Node.ELEMENT_NODE) {
				
				Element currentElement = (Element)currentNode;
				
				if(currentElement.getTagName() == "vertex" && graph == null) {
					
					int vertexCount = Integer.parseInt(currentElement.getAttribute("count"));
					
					graph = new Graph(vertexCount);
				}
				
				if(currentElement.getTagName() == "edge" && graph != null) {
					int id1 = Integer.parseInt(currentElement.getAttribute("id1"));
					int id2 = Integer.parseInt(currentElement.getAttribute("id2"));
					float weight = Float.parseFloat(currentElement.getAttribute("weight"));
					
					graph.AddEdge(id1, id2, weight);
				}
				
			}
		}
		
		return graph;
	}
	
}
