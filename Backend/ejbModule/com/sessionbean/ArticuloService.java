package com.sessionbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entity.Articulo;
import com.entity.Categoria;
import com.entity.ItemRecepcionCompra;
import com.entity.ItemSolicitudArticulo;
import com.entity.Marca;
import com.entity.Pais;
import com.entity.RecepcionCompra;
import com.entity.SolicitudArticulos;
import com.interfaces.ArticuloServiceLocal;
import com.interfaces.ArticuloServiceRemote;
import com.vo.ArticuloVO;
import com.vo.CategoriaVO;
import com.vo.ItemRecepcionCompraVO;
import com.vo.ItemSolicitudArticuloVO;
import com.vo.MarcaVO;
import com.vo.PaisVO;
import com.vo.RecepcionCompraVO;
import com.vo.SolicitudArticulosVO;

@Stateless
@LocalBean
@SuppressWarnings("unchecked")
public class ArticuloService implements ArticuloServiceRemote, ArticuloServiceLocal {

	@PersistenceContext(unitName="MyPU")
	private EntityManager manager;
	
    public ArticuloService() {}
    
    @Override
    public List<PaisVO> obtenerPaises() {
    	Query query = manager.createQuery("FROM "+Pais.class.getSimpleName());
		List<Pais> paises = query.getResultList();
    	List<PaisVO> paisesVO = new ArrayList<PaisVO>();
    	for(Pais pais : paises){
    		paisesVO.add(pais.crearVO());
    	}
    	return paisesVO;
    }
    
    @Override
    public List<MarcaVO> obtenerMarcas() {
    	Query query = manager.createQuery("FROM "+Marca.class.getSimpleName());
		List<Marca> marcas = query.getResultList();
    	List<MarcaVO> marcasVO = new ArrayList<MarcaVO>();
    	for(Marca marca : marcas){
    		marcasVO.add(marca.crearVO());
    	}
    	return marcasVO;
    }
    
    @Override
    public List<ArticuloVO> obtenerArticulos() {
    	Query query = manager.createQuery("FROM "+Articulo.class.getSimpleName());
		List<Articulo> articulos = query.getResultList();
    	List<ArticuloVO> articulosVO = new ArrayList<ArticuloVO>();
    	for(Articulo marca : articulos){
    		articulosVO.add(marca.crearVO());
    	}
    	return articulosVO;
    }
    
	@Override
	public ArticuloVO buscarArticuloPorId(String codigo) {
		Query query = manager.createQuery("FROM "+Articulo.class.getSimpleName()+"  WHERE codigo=:codigo");
		query.setParameter("codigo", codigo);
		return ((Articulo) query.getSingleResult()).crearVO();
	}
	
	private Pais buscarPaisPorId(Integer id) {
		Query query = manager.createQuery("FROM "+Pais.class.getSimpleName()+" c WHERE c.id=:id");
		query.setParameter("id", id);
		return (Pais) query.getSingleResult();
	}
	
	private Marca buscarMarcaPorId(Integer id) {
		Query query = manager.createQuery("FROM "+Marca.class.getSimpleName()+" c WHERE c.id=:id");
		query.setParameter("id", id);
		return (Marca) query.getSingleResult();
	}
	
	@Override
	public void guardarArticulo(ArticuloVO articuloVO) {
		Articulo articulo = new Articulo();
		articulo.setNombre(articuloVO.getNombre());
		articulo.setCodigo(articuloVO.getCodigo());
		articulo.setDescripcion(articuloVO.getDescripcion());
		articulo.setMarca(buscarMarcaPorId(articuloVO.getMarca().getId()));
		articulo.setOrigen(buscarPaisPorId(articuloVO.getOrigen().getId()));
		articulo.setPrecio(articuloVO.getPrecio());
		manager.persist(articulo);
	}
	
	@Override
	public void eliminarArticulo(String codigo) {
		Query query = manager.createQuery("DELETE FROM "+Articulo.class.getSimpleName()+" WHERE codigo=:codigo");
		query.setParameter("codigo", codigo);
		query.executeUpdate();
	}

	@Override
	public List<CategoriaVO> obtenerCategorias() {
    	Query query = manager.createQuery("FROM "+Categoria.class.getSimpleName());
		List<Categoria> categorias= query.getResultList();
    	List<CategoriaVO> categoriasVO = new ArrayList<CategoriaVO>();
    	for(Categoria categoria : categorias){
    		categoriasVO.add(categoria.crearVO());
    	}
    	return categoriasVO;
	}
	
	@Override
	public List<ArticuloVO> buscarArticulo(ArticuloVO articulo){
		String queryString = "FROM "+Articulo.class.getSimpleName()+ " where 1=1 ";
		
		if(articulo.getCategoria() != null && articulo.getCategoria().getId() != null){
			queryString+=" and categoria.id=:idCategoria";
		}
		if(articulo.getNombre() != null && !articulo.getNombre().isEmpty()){
			queryString+=" and nombre=:nombre";
		}
		if(articulo.getCodigo() != null && !articulo.getCodigo().isEmpty()){
			queryString+=" and codigo=:codigo";
		}
		
		Query query = manager.createQuery(queryString);
		
		
		if(articulo.getCategoria() != null){
			query.setParameter("idCategoria", articulo.getCategoria().getId());
		}
		if(articulo.getNombre() != null && !articulo.getNombre().isEmpty()){
			query.setParameter("nombre", articulo.getNombre());
		}
		if(articulo.getCodigo() != null && !articulo.getCodigo().isEmpty()){
			query.setParameter("codigo", articulo.getCodigo());
		}
		
		List<Articulo> articulos = query.getResultList();
    	List<ArticuloVO> articulosVO = new ArrayList<ArticuloVO>();
    	for(Articulo marca : articulos){
    		articulosVO.add(marca.crearVO());
    	}
    	
    	return articulosVO;
	}

	@Override
	public void guardarSolicitudArticulos(SolicitudArticulosVO solicitudVO) {
		SolicitudArticulos solicitud = new SolicitudArticulos();
		solicitud.setEstado("Pendiente");
		solicitud.setFechaEmision(solicitudVO.getFechaEmision());
		List<ItemSolicitudArticulo> items = new ArrayList<ItemSolicitudArticulo>();
		for (ItemSolicitudArticuloVO itemVO : solicitudVO.getItemSolicitudArticulo()){
			ItemSolicitudArticulo item = new ItemSolicitudArticulo();
			item.setCantidad(itemVO.getCantidad());
			Articulo articulo = obtenerArticulo(itemVO.getArticulo().getCodigo());
			item.setArticulo(articulo);
			items.add(item);
		}
		solicitud.setItemSolicitudArticulo(items);
		manager.persist(solicitud);
	}
	
	private Articulo obtenerArticulo(String codigo){
		Query query = manager.createQuery("FROM "+Articulo.class.getSimpleName()+ " where codigo=:codigo");
		query.setParameter("codigo", codigo);
		return (Articulo) query.getSingleResult();
	}

	@Override
	public void guardarRecepcionCompra(RecepcionCompraVO recepcionCompraVO) {
		RecepcionCompra recepcion = new RecepcionCompra();
		recepcion.setFechaRecepcion(recepcionCompraVO.getFechaRecepcion());
		
		List<ItemRecepcionCompra> items = new ArrayList<ItemRecepcionCompra>();
		for (ItemRecepcionCompraVO itemVO : recepcionCompraVO.getItemRecepcionCompra()){
			ItemRecepcionCompra item = new ItemRecepcionCompra();
			item.setCantidad(itemVO.getCantidad());
			Articulo articulo = obtenerArticulo(itemVO.getArticulo().getCodigo());
			articulo.setStock(articulo.getStock()+itemVO.getCantidad());
			manager.merge(articulo);
			item.setArticulo(articulo);
			items.add(item);
		}
		recepcion.setItemRecepcionCompra(items);
		manager.persist(recepcion);
		
	}

	@Override
	public List<SolicitudArticulosVO> obtenerSolicitudesArticulosPendientes() {
		Query query = manager.createQuery("FROM "+SolicitudArticulos.class.getSimpleName()+ " where estado=:estado");
		query.setParameter("estado", "Pendiente");
		return query.getResultList();
	}
	
}
