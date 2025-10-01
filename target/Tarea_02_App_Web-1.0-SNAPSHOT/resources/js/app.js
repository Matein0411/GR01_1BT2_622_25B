// JS mínimo para filtro client-side en los listados
window.addEventListener('DOMContentLoaded', function(){
  const usersSearch = document.getElementById('searchUsers');
  if(usersSearch){
    usersSearch.addEventListener('input', function(e){
      const q = e.target.value.toLowerCase().trim();
      document.querySelectorAll('#usersList .card').forEach(card => {
        const name = card.dataset.name ? card.dataset.name.toLowerCase() : '';
        const email = card.dataset.email ? card.dataset.email.toLowerCase() : '';
        const match = name.includes(q) || email.includes(q);
        card.style.display = match ? '' : 'none';
      });
    });
  }

  const vehiclesSearch = document.getElementById('searchVehicles');
  if(vehiclesSearch){
    vehiclesSearch.addEventListener('input', function(e){
      const q = e.target.value.toLowerCase().trim();
      document.querySelectorAll('#vehiclesList .card').forEach(card => {
        const placa = card.dataset.placa ? card.dataset.placa.toLowerCase() : '';
        const marca = card.dataset.marca ? card.dataset.marca.toLowerCase() : '';
        const usuario = card.dataset.usuario ? card.dataset.usuario.toLowerCase() : '';
        const match = placa.includes(q) || marca.includes(q) || usuario.includes(q);
        card.style.display = match ? '' : 'none';
      });
    });
  }
});