<div style="width: 60%">
        <div>
            <h2>Add city </h2>
            <label>name:
                <label>${client.name}</label><br>
            </label>
            <label><br>surname:
                <label>${client.surname}</label>
            </label>
            <label><br>patronymic:
                <label>${client.patronymic}</label>
            </label>
            <label><br>dateOfBirth:
                <label>${client.dateOfBirth}</label>
            </label>
            <label><br>phoneNumber:
                <label>${client.phoneNumber}</label>
            </label>
            <label><br>email:
                <label>${client.email}</label>
            </label>
            <label>gender:
                <label>${client.gender}</label>
            </label>
    </div>
   <div>
       <table id="table_id" class="display" style="width:100%">
           <thead>
           <tr>
               <th>Column 1</th>
               <th>Column 2</th>
               <th>Column 2</th>
           </tr>
           </thead>
           <tbody>
           <c:forEach var="ApartmentEntity" items="${client.apartmentsByIdClient}">
           <tr>
               <td> <c:out value="${ApartmentEntity.idApartment}"/></td>
               <td> <c:out value="${ApartmentEntity.numberApartment}"/></td>
               <td> <c:out value="${ApartmentEntity.apartmentOwner}"/></td>
           </tr>
           </c:forEach>
           </tbody>
       </table>
   </div>
    <button onclick="location.href='./'">Back to main</button>
</div>
    <script type="text/javascript">
    $(document).ready( function () {
    $('#table_id').DataTable();
    } );
    </script>

</body>
</html>